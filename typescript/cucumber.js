// cucumber.js
let common = [
  "features/**/*.feature", // Specify our feature files
  //   "--require-module ts-node/register", // Load TypeScript module
  "--require features/step-definitions/**/*.js", // Load step definitions
  "--format progress-bar", // Load custom formatter
  "--format node_modules/cucumber-pretty", // Load custom formatter
].join(" ");

module.exports = {
  default: common,
};
