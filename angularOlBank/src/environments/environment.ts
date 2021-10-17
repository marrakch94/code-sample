// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export const environment = {
    production: false,
    apiUrl : 'http://localhost:8082/',
    folder: '',
  powerBI: {
    reportBaseURL: 'https://app.powerbi.com/reportEmbed',
    qnaBaseURL: 'https://app.powerbi.com/qnaEmbed',
    tileBaseURL: 'https://app.powerbi.com/embed',
    groupID: '<group-id>',
    reportID: '<report-id>'
  }
};
