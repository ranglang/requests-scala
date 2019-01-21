import mill._
import mill.scalalib.publish.{Developer, License, PomSettings, VersionControl}
import scalalib._

object requests extends Cross[RequestsModule]("2.11.12", "2.12.6")
class RequestsModule(val crossScalaVersion: String) extends CrossScalaModule with PublishModule {
  def publishVersion = "0.1.7"
  def artifactName = "requests"
  def pomSettings = PomSettings(
    description = "Scala port of the popular Python Requests HTTP client",
    organization = "com.lihaoyi",
    url = "https://github.com/lihaoyi/requests",
    licenses = Seq(License.MIT),
    versionControl = VersionControl.github("lihaoyi", "requests-scala"),
    developers = Seq(
      Developer("lihaoyi", "Li Haoyi","https://github.com/lihaoyi")
    )
  )
  object test extends Tests{
    def ivyDeps = Agg(ivy"com.lihaoyi::utest::0.6.3")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}
