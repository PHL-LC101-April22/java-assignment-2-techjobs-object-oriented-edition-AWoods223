package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
        public void testSettingJobId(){
        Job jobIdOne = new Job();
        Job jobIdTwo = new Job();
        assertNotEquals( jobIdOne,jobIdTwo);
    }

    @Test
        public void testJobConstructorSetsAllFields(){
        Job jobOne =
                new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));


        //System.out.println(jobOne.getName());
        assertTrue(jobOne.getName() instanceof String);
        assertEquals(jobOne.getName(), "Product tester");

        assertTrue(jobOne.getEmployer() instanceof Employer);
        assertEquals("ACME", jobOne.getEmployer().getValue());

        assertTrue(jobOne.getLocation() instanceof Location);
        assertEquals( "Desert", jobOne.getLocation().getValue());

        assertTrue(jobOne.getPositionType() instanceof PositionType);
        assertEquals("Quality control", jobOne.getPositionType().getValue());

        assertTrue(jobOne.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", jobOne.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality(){
        Job jobIdOne = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job jobIdTwo = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(jobIdOne.equals(jobIdTwo));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){

        Job jobObjectNewLine = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals('\n', jobObjectNewLine.toString().charAt(0));
jobObjectNewLine.toString().endsWith("\n");
        assertEquals(true, jobObjectNewLine.toString().endsWith("\n"));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobContainsLabelsAndData = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String[] lines = jobContainsLabelsAndData.toString().trim().split("\n");

        System.out.println(jobContainsLabelsAndData.toString());

        assertTrue(lines.length == 6);

        assertTrue(lines[0].startsWith("ID:"));
        assertTrue(lines[1].startsWith("Name:"));
        assertTrue(lines[2].startsWith("Employer:"));
        assertTrue(lines[3].startsWith("Location:"));
        assertTrue(lines[4].startsWith("Position Type:"));
        assertTrue(lines[5].startsWith("Core Competency:"));

        assertTrue(lines[0].endsWith(Integer.toString(jobContainsLabelsAndData.getId())));
        assertTrue(lines[1].endsWith(jobContainsLabelsAndData.getName()));
        assertTrue(lines[2].endsWith(jobContainsLabelsAndData.getEmployer().toString()));
        assertTrue(lines[3].endsWith(jobContainsLabelsAndData.getLocation().toString()));
        assertTrue(lines[4].endsWith(jobContainsLabelsAndData.getPositionType().toString()));
        assertTrue(lines[5].endsWith(jobContainsLabelsAndData.getCoreCompetency().toString()));

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobContainsEmptyField = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String[] lines = jobContainsEmptyField.toString().trim().split("\n");

        System.out.println(jobContainsEmptyField.toString());

//        // removing the ID field, which will always have data
//        List<String> list = new ArrayList<String>(Arrays.asList(lines));
//        list.remove(0);
//        lines = list.toArray(new String[0]);

        String unavailable = "Data not available";

        for (String line : lines) {
            assertTrue(line.endsWith(unavailable));
        }
    }
//        assertTrue(true, jobContainsEmptyField.toString().isEmpty());
//        //assertEquals("", jobContainsEmptyField.toString().isEmpty());
//    }


}
