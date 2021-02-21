// cucumber.js
let common = [
  "features/**/*.feature", // Specify our feature files
  "--require-module ts-node/register", // Load TypeScript module
  "--require features/step-definitions/**/*.js", // Load step definitions
  "--format progress-bar", // Load custom formatter
  "--format @cucumber/pretty-formatter", // Load custom formatter
  "--publish-quiet",
].join(" ");

module.exports = {
  default: common,
};
