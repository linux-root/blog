import laika.helium.Helium
import laika.format.Markdown
import laika.config.SyntaxHighlighting

lazy val root = (project in file("."))
  .settings(
    name         := "blog",
    version      := "0.1",
    scalaVersion := "3.6.1",
    laikaTheme   := theme,
    laikaExtensions ++= Seq(Markdown.GitHubFlavor, SyntaxHighlighting),
    laikaConfig := LaikaConfig.defaults
      .withConfigValue(
        "laika.theme.fonts.body",
        "Inter, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif"
      )
      .withConfigValue(
        "laika.theme.fonts.code",
        "'BlexMono', 'JetBrains Mono', 'Fira Code', 'Source Code Pro', 'Consolas', 'Monaco', 'Menlo', 'Ubuntu Mono', monospace"
      )
      .withConfigValue(
        "laika.theme.fonts.navigation",
        "Inter, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif"
      )
  )
  .enablePlugins(LaikaPlugin)

lazy val theme = Helium.defaults.all
  .metadata(
    title = Some("Watson Dinh "),
    language = Some("en")
  )
  .build
