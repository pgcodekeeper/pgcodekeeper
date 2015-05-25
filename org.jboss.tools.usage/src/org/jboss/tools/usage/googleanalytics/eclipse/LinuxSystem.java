/*******************************************************************************
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.googleanalytics.eclipse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;

/**
 * @author André Dietisheim, Alexey Kazakov
 */
public class LinuxSystem {

	public static final LinuxSystem INSTANCE = new LinuxSystem();
	
	/**
	 * @see <a href="http://linuxmafia.com/faq/Admin/release-files.html"> an
	 *      extensive list of release file locations</a>
	 * 
	 * @see <a
	 *      href="http://superuser.com/questions/11008/how-do-i-find-out-what-version-of-linux-im-running">
	 *      release-file strings</a>
	 */
	public final LinuxDistro ARCH = new LinuxDistro("Arch", "/etc/arch-release");
	public final LinuxDistro CENTOS = new ReleaseFileContentCheckedDistro("CentOS", "/etc/redhat-release");
	public final LinuxDistro CENTOS_ALTERNATIVE = new LinuxDistro("CentOS", "/etc/centos-release");
	public final LinuxDistro DEBIAN = new LinuxDistro("Debian", "/etc/debian_version");
	public final LinuxDistro DEBIAN_ALTERNATIVE = new LinuxDistro("Debian", "/etc/debian_release");
	public final LinuxDistro FEDORA = new LinuxDistro("Fedora", "/etc/fedora-release");
	public final LinuxDistro GENTOO = new LinuxDistro("Gentoo", "/etc/gentoo-release");
	public final LinuxDistro YELLOWDOG = new LinuxDistro("YellowDog", "/etc/yellowdog-release");
	public final LinuxDistro KNOPPIX = new LinuxDistro("Knoppix", "knoppix_version");
	public final LinuxDistro MAGEIA = new LinuxDistro("Mageia", "/etc/mageia-release");
	public final LinuxDistro MANDRAKE = new LinuxDistro("Mandrake", "/etc/mandrake-release");
	public final LinuxDistro MANDRIVA = new LinuxDistro("Mandriva", "/etc/mandriva-release");
	public final LinuxDistro MANDRIVA_ALTERNATIVE = new ReleaseFileContentCheckedDistro("Mandriva", "/etc/version");
	public final LinuxDistro MINT = new ReleaseFileContentCheckedDistro("LinuxMint", "/etc/lsb-release");
	public final LinuxDistro PLD = new LinuxDistro("PLD", "/etc/pld-release");
	public final LinuxDistro REDHAT = new ReleaseFileContentCheckedDistro("Red Hat", "/etc/redhat-release");
	public final LinuxDistro SLACKWARE = new LinuxDistro("Slackware", "/etc/slackware-version");
	public final LinuxDistro SLACKWARE_ALTERNATIVE = new LinuxDistro("Slackware", "/etc/slackware-release");
	public final LinuxDistro SUSE = new LinuxDistro("SUSE", "/etc/SuSE-release");
	public final LinuxDistro OPEN_SUSE = new ReleaseFileContentCheckedDistro("openSUSE", "/etc/os-release");
	public final LinuxDistro SUSE_ALTERNATIVE = new ReleaseFileContentCheckedDistro("SUSE", "/etc/os-release");
	public final LinuxDistro UBUNTU = new ReleaseFileContentCheckedDistro("Ubuntu", "/etc/lsb-release");
	public final LinuxDistro PUPPY = new LinuxDistro("Puppy", "/etc/puppyversion");
	public final LinuxDistro DEFAULT_OS_RELEASE_FILE_BASED_DISTRO = new OsReleaseFileDistro();
	public final LinuxDistro LIB_OS_RELEASE_FILE_BASED_DISTRO_ALTERNATIVE = new OsReleaseFileDistro("/usr/lib/os-release");

	private final LinuxDistro[] ALL = new LinuxDistro[] {
			CENTOS,
			CENTOS_ALTERNATIVE,
			MINT,
			UBUNTU,
			DEBIAN,
			FEDORA,
			GENTOO,
			KNOPPIX,
			MANDRAKE,
			MANDRIVA,
			PLD,
			REDHAT,
			SLACKWARE,
			SLACKWARE_ALTERNATIVE,
			SUSE,
			OPEN_SUSE,
			SUSE_ALTERNATIVE,
			YELLOWDOG,
			ARCH,
			DEBIAN_ALTERNATIVE,
			DEFAULT_OS_RELEASE_FILE_BASED_DISTRO,
			LIB_OS_RELEASE_FILE_BASED_DISTRO_ALTERNATIVE
	};

	private LinuxDistro detectedDistro;
	private String nameAndVersion;
	boolean firstTimeDistroDetection = true;
	boolean firstTimeNameDetection = true;

	public LinuxDistro getDistro() {
		if(firstTimeDistroDetection && detectedDistro==null) {
			firstTimeDistroDetection = false;
			if(isLinux()) {
				for (LinuxDistro distro : ALL) {
					if (distro.isDetected()) {
						detectedDistro = distro;
						break;
					}
				}
			}
		}
		return detectedDistro;
	}

	protected boolean isLinux() {
		return Platform.getOS().toLowerCase().indexOf("linux")>-1;
	}

	public String getDistroNameAndVersion() {
		if(firstTimeNameDetection && nameAndVersion==null) {
			firstTimeNameDetection = false;
			LinuxDistro distro = getDistro();
			if(isLinux()) {
				nameAndVersion = (distro != null)?distro.getNameAndVersion():"Unknown";
			}
		}
		return nameAndVersion;
	}

	protected boolean exists(String releaseFilePath) {
		return releaseFilePath != null
				&& releaseFilePath.length() > 0
				&& new File(releaseFilePath).exists();
	}

	protected String getDistroFileContent(String filePath) throws IOException {
		int charachtersToRead = 1024;
		StringBuilder builder = new StringBuilder(charachtersToRead);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[charachtersToRead];
		int charRead = 0;
		while ((charRead = reader.read(buf)) != -1 && builder.length() < charachtersToRead) {
			String readData = String.valueOf(buf, 0, charRead);
			builder.append(readData);
		}
		reader.close();
		return builder.toString();
	}

	public class LinuxDistro {

		/**
		 * The pattern to match the contents of the release-file -
		 * /etc/fedora-release etc. Attention: Ubuntu has multi-line release
		 * file
		 */
		private final Pattern VERSION_REGEX = Pattern.compile("([0-9.]+)");

		protected final String releaseFilePath;
		protected String name;

		protected LinuxDistro(String name, String releaseFilePath) {
			this.name = name;
			this.releaseFilePath = releaseFilePath;
		}

		protected boolean isDetected() {
			return exists(getReleaseFilePath());
		}

		public String getName() {
			return name;
		}

		public String getVersion() {
			String distroString = getReleaseFileContent();
			Matcher matcher = VERSION_REGEX.matcher(distroString);
			if (matcher.find()) {
				return matcher.group(1);
			}
			return "";
		}

		public String getNameAndVersion() {
			return new StringBuilder().append(getName()).append(" ").append(getVersion()).toString().trim();
		}

		public String getReleaseFilePath() {
			return releaseFilePath;
		}

		protected String getReleaseFileContent() {
			try {
				String distroString = getDistroFileContent(getReleaseFilePath());
				if(distroString!=null) {
					return distroString;
				}
			} catch (IOException e) {
				// Ignore
			}
			return "";
		}

		@Override
		public String toString() {
			return getName();
		}
	}

	/**
	 * A distribution definition that checks for presence of the given distro
	 * name in the given release file.
	 */
	public class ReleaseFileContentCheckedDistro extends LinuxDistro {

		public ReleaseFileContentCheckedDistro(String name, String releaseFilePath) {
			super(name, releaseFilePath);
		}

		@Override
		protected boolean isDetected() {
			boolean fileExists = exists(getReleaseFilePath());
			if (fileExists) {
				String content = getReleaseFileContent();
				return content.toLowerCase().indexOf(getName().toLowerCase()) >= 0;
			}
			return false;
		}
	}

	/**
	 * A distribution definition based on "/etc/os-release" file.
	 * The name is read from the "NAME=" property. 
	 * See http://www.freedesktop.org/software/systemd/man/os-release.html
	 */
	public class OsReleaseFileDistro extends LinuxDistro {

		protected OsReleaseFileDistro() {
			this("/etc/os-release");
		}

		protected OsReleaseFileDistro(String releaseFilePath) {
			super("Unknown", releaseFilePath);
		}

		@Override
		public String getName() {
			if(!isDetected()) {
				return super.getName();
			}
			String content = getReleaseFileContent();
			Properties p = new Properties();
			try {
				p.load(new StringReader(content));
				String stName = p.getProperty("NAME");
				if(stName==null) {
					stName = p.getProperty("ID");
				}
				if(stName!=null) {
					if(stName.startsWith("\"") && stName.endsWith("\"") && stName.length()>3) {
						stName = stName.substring(1, stName.length()-1);
					}
					name = stName;
				}
			} catch (IOException e) {
				// Ignore
			}
			return name;
		}
	}
}