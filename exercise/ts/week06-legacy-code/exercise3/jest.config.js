module.exports = {
    preset: "ts-jest",
    testEnvironment: "node",
    transform: {'^.+\\.ts?$': 'ts-jest'},
    testRegex: '/tests/.*\\.(tests|spec)?\\.(ts|tsx)$'
};