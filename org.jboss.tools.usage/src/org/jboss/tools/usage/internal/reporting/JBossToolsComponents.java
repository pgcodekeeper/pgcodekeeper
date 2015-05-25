/*******************************************************************************
 * Copyright (c) 2010-2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.reporting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;

/**
 * @author Andre Dietisheim, Alexey Kazakov
 */
public class JBossToolsComponents {

	/**
	 * The jboss tools features to check and report.
	 * <p>
	 * ATTENTION: the following features do not start with org.jboss.tools
	 * </p>
	 * <p>
	 * <ul>
	 * <li>org.hibernate.eclipse.feature</li>
	 * <li>org.jboss.ide.eclipse.freemarker.feature</li>
	 * <li>org.drools.eclipse.feature</li>
	 * <li>org.jboss.ide.eclipse.as.feature</li>
	 * <li>org.mozilla.xulrunner.feature</li>
	 * </ul>
	 * </p>
	 * 
	 */
	public enum JBossToolsFeatureIdentifiers {
		/*AEROGEAR("org.jboss.tools.aerogear.thym.feature", "org.jboss.tools.aerogear.thym"),
		ARQUILLIAN("org.jboss.tools.arquillian.feature", "org.jboss.tools.arquillian.core"),
		AS("org.jboss.ide.eclipse.as.feature", "org.jboss.ide.eclipse.as.core"),
		//Archives is required by AS, will always show up.
		//ARCHIVES("org.jboss.ide.eclipse.archives.feature", "org.jboss.ide.eclipse.archives.core"),
		BIRT("org.jboss.tools.birt.feature", "org.jboss.tools.birt.core"),
		BPEL("org.jboss.tools.bpel.feature", "org.jboss.tools.bpel.runtimes"),
		BPMN2("org.eclipse.bpmn2.modeler", "org.eclipse.bpmn2.modeler.core"),
		CDI("org.jboss.tools.cdi.feature", "org.jboss.tools.cdi.core"),
		//We can detect central via the central event. 
		//CENTRAL("org.jboss.tools.central.feature", "org.jboss.tools.central"),
		//Common is commong - will always be there part of something else.
		//COMMON("org.jboss.tools.common.feature", "org.jboss.tools.common"),
		//Delta cloud never really active.
		//DELTACLOUD("org.jboss.tools.deltacloud.feature", "org.jboss.tools.deltacloud.core"),
		DROOLS("org.drools.eclipse.feature", "org.drools.eclipse"),
		ESB("org.jboss.tools.esb.feature", "org.jboss.tools.esb.core"),
		//Examples is something installed together with others. Not informative to track on its own.
		//EXAMPLES("org.jboss.tools.project.examples.feature", "org.jboss.tools.project.examples"),
		FORGE("org.jboss.tools.forge.feature", "org.jboss.tools.forge.core"),
		FUSE("org.fusesource.ide.camel.editor.feature", "org.fusesource.ide.camel.editor"),
		FLOW("org.jboss.tools.flow.common.feature", "org.jboss.tools.flow.common"),
		FREEMARKER("org.jboss.ide.eclipse.freemarker.feature", "org.jboss.ide.eclipse.freemarker"),
		GWT("org.jboss.tools.gwt.feature", "org.jboss.tools.gwt.core"),
		HIBERNATE("org.hibernate.eclipse.feature", "org.hibernate.eclipse"),
		JBPM("org.jboss.tools.jbpm.common.feature", "org.jboss.tools.jbpm.common"),
		//JMX is similar to archives, very unlikely installed on its own
		//JMX("org.jboss.tools.jmx.feature", "org.jboss.tools.jmx.core"),
		JSF("org.jboss.tools.jsf.feature", "org.jboss.tools.jsf"),
		LIVERELOAD("org.jboss.tools.livereload.feature", "org.jboss.tools.livereload.core"),
		MAVEN("org.jboss.tools.maven.feature", "org.jboss.tools.maven.core"),
		MODESHAPE("org.jboss.tools.modeshape.rest.feature", "org.jboss.tools.modeshape.rest"),
		OPENSHIFT("org.jboss.tools.openshift.express.feature", "org.jboss.tools.openshift.express.client"),
		PORTLET("org.jboss.tools.portlet.feature", "org.jboss.tools.portlet.core"),
		//Profiler was never really active.
		//PROFILER("org.jboss.tools.profiler.feature", "org.jboss.tools.profiler.ui"),
		RUNTIME("org.jboss.tools.runtime.feature", "org.jboss.tools.runtime.core"),
		SEAM("org.jboss.tools.seam.feature", "org.jboss.tools.seam.core"),
		SMOOKS("org.jboss.tools.smooks.feature", "org.jboss.tools.smooks.core"),
		// Was until 28. August 2014 registered as SWTICHYARD
		SY("org.switchyard.tools.feature", "org.switchyard.tools"),
		TEIID("org.teiid.designer.feature", "org.teiid.core.designer"),
		THYM("org.eclipse.thym.feature", "org.eclipse.thym.core"),
		VPE("org.jboss.tools.vpe.feature", "org.jboss.tools.vpe"),
		//Never really been active
		//WORKINGSET("org.jboss.tools.workingset.feature", "org.jboss.tools.workingset.core"),
		WS("org.jboss.tools.ws.feature", "org.jboss.tools.ws.core"), // includes jax-rs
		XULRUNNER("org.mozilla.xulrunner.feature", "org.mozilla.xulrunner");*/
		codekeeperUI("ru.taximaxim.codekeeper.feature", "ru.taximaxim.codekeeper.ui");

		private String featureId;
		private String pluginId;

		JBossToolsFeatureIdentifiers(String featureIdentifier, String corePluginIdentifier) {
			this.featureId = featureIdentifier;
			this.pluginId = corePluginIdentifier;
		}

		public boolean corePluginInstalled() {
			 return Platform.getBundle(pluginId)!=null;
		}

		public String getComponentName() {
			return name();
		}

		/**
		 * May return null
		 * @return
		 */
		public String getFeatureId() {
			return featureId;
		}

		/**
		 * May return null
		 * @return
		 */
		public String getPluginId() {
			return pluginId;
		}
	}

	private JBossToolsComponents() {
		// inhibit instantiation
	}

	/**
	 * Returns the jboss components that the given bundle group provider
	 * provides
	 * 
	 * @param bundleGroupProviders
	 *            the bundles group providers to check for jboss components
	 * @param bundleProvider
	 *            an implementation that allows you to query for a bundle
	 *            whether it's installed
	 * 
	 * @return
	 */
	public static Collection<String> getComponentIds(IBundleGroupProvider[] bundleGroupProviders, IBundleProvider bundleProvider) {
		Set<String> componentNames = new TreeSet<String>();
		Map<String, String> features = new HashMap<String, String>();
		for (JBossToolsFeatureIdentifiers identifier : JBossToolsFeatureIdentifiers.values()) {
			if(identifier.featureId!=null) {
				features.put(identifier.featureId, identifier.name());
			}
			if (identifier.pluginId!=null && bundleProvider.isInstalled(identifier.pluginId)) {
				componentNames.add(identifier.name());
			}
		}
		for (IBundleGroupProvider bundleGroupProvider : bundleGroupProviders) {
			for (IBundleGroup group : bundleGroupProvider.getBundleGroups()) {
				String name = features.get(group.getIdentifier());
				if(name!=null) {
					componentNames.add(name);
				}
			}
		}
		return componentNames;
	}

	/**
	 * An interface for classes that allow one to query for installable bundle(s).
	 */
	public interface IBundleProvider {
		public boolean isInstalled(String symbolicName);
	}
}
