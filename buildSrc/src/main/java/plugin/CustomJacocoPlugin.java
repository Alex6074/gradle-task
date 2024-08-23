package plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;
import org.gradle.testing.jacoco.plugins.JacocoPlugin;
import org.gradle.testing.jacoco.tasks.JacocoReport;

public class CustomJacocoPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.getPlugins().apply(JacocoPlugin.class);

        target.getTasks().withType(JacocoReport.class).configureEach(jacocoReport -> {
            jacocoReport.setGroup("verification");

            jacocoReport.dependsOn("test");

            jacocoReport.getReports().getXml().getRequired().set(false);
            jacocoReport.getReports().getCsv().getRequired().set(false);
            jacocoReport.getReports().getHtml().getRequired().set(true);
            jacocoReport.getReports().getHtml().getOutputLocation().set(target.getLayout().getBuildDirectory().dir("jacocoHtml"));
        });

        target.getTasks().withType(Test.class).configureEach(test -> test.finalizedBy("jacocoTestReport"));
    }
}
