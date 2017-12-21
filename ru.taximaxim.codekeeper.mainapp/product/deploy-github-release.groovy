import groovy.json.JsonSlurper

/*
Usage: call from the maven build using groovy-maven-plugin.
Required parameters:
    GITHUB_TOKEN        environment variable containing Github's auth token
    cli-version         pom property containing build's unqualified version
    cli-archive-file    pom property containing path to a release zip
*/

AUTH_TOKEN = System.getenv('GITHUB_TOKEN')
VERSION = properties['cli-version']
FILE = properties['cli-archive-file']

assert AUTH_TOKEN?.length()
assert VERSION?.length()
assert FILE?.length()

CREATE_URL = "https://api.github.com/repos/pgcodekeeper/pgcodekeeper/releases"
CREATE_JSON = """{
    "tag_name": "v${VERSION}",
    "name": "pgCodeKeeper ${VERSION}"
}"""
FILENAME = "pgCodeKeeper-cli-${VERSION}.zip"

println("Querying ${CREATE_URL}")
def create = (HttpURLConnection) new URL(CREATE_URL).openConnection()
create.requestMethod = 'POST'
create.addRequestProperty('Authorization', "token ${AUTH_TOKEN}")
create.addRequestProperty('User-Agent', 'pgCodeKeeper deploy script')
create.doOutput = true
create.outputStream.write(CREATE_JSON.getBytes("UTF-8"))

def postCode = create.getResponseCode()
if (postCode < 200 || postCode >= 300) {
    throw new RuntimeException("ERROR: creating new release: ${postCode}\n" + create.errorStream.getText())
}
println('SUCCESS: created new release')

def uploadUrl = new JsonSlurper().parse(create.inputStream)['upload_url']
uploadUrl = uploadUrl.substring(0, uploadUrl.indexOf('{?')) + "?name=${FILENAME}"

println("Querying ${uploadUrl}")
def upload = (HttpURLConnection) new URL(uploadUrl).openConnection()
upload.requestMethod = 'POST'
upload.addRequestProperty('Authorization', "token ${AUTH_TOKEN}")
upload.addRequestProperty('User-Agent', 'pgCodeKeeper deploy script')
upload.addRequestProperty('Content-Type', 'application/zip')
upload.doOutput = true
upload.outputStream.write(new File(FILE).bytes)

postCode = upload.getResponseCode()
if (postCode < 200 || postCode >= 300) {
    throw new RuntimeException("ERROR: uploading release asset: ${postCode}\n" + upload.errorStream.getText())
}
println('SUCCESS: uploaded release asset')
