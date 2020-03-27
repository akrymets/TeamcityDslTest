import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {

    buildType(TestProject_TestBuildTask)

    template(TestProject_TestTemplate)
}

object TestProject_TestBuildTask : BuildType({
    templates(TestProject_TestTemplate)
    id("TestBuildTask")
    name = "TestBuildTask"

    steps {
        script {
            name = "Second echo"
            id = "RUNNER_2"
            scriptContent = """echo "Oppa Gungnam style""""
        }
    }
})

object TestProject_TestTemplate : Template({
    id("TestTemplate")
    name = "testTemplate"

    steps {
        script {
            name = "Show hello message"
            id = "RUNNER_1"
            scriptContent = """echo "Hello world 111111122222222""""
        }
    }
})
