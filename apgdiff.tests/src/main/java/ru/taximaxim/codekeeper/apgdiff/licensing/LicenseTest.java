package ru.taximaxim.codekeeper.apgdiff.licensing;

import java.io.IOException;

import org.junit.Test;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.TEST;
import cz.startnet.utils.pgdiff.loader.JdbcLoaderTest;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;

public class LicenseTest {

    @Test
    public void testLicenseNormal() throws IOException, LicenseException {
        new License(ApgdiffTestUtils.getTestLicenseUrl().toString(), false);
    }

    @Test(expected = LicenseException.class)
    public void testLicenseCaps() throws IOException, LicenseException {
        new License(LicenseTest.class.getResourceAsStream("testlic_nocli"), false);
    }

    @Test(expected = LicenseException.class)
    public void testLicenseExpired() throws IOException, LicenseException {
        new License(LicenseTest.class.getResourceAsStream("testlic_expired"), false);
    }

    @Test(expected = LicenseException.class)
    public void testLicenseInactive() throws IOException, LicenseException {
        new License(LicenseTest.class.getResourceAsStream("testlic_inactive"), false);
    }

    @Test(expected = LicenseException.class)
    public void testLicenseSchemaSize() throws IOException, LicenseException, InterruptedException {
        License l = new License(LicenseTest.class.getResourceAsStream("testlic_schemalimit"), false);
        PgDiffArguments args = new PgDiffArguments();
        args.setLicense(l);
        ApgdiffTestUtils.loadTestDump(TEST.RESOURCE_DUMP, JdbcLoaderTest.class, args);
    }
}
