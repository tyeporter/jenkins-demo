job('NodeJS Example') {
    scm {
        git('https://github.com/tyeporter/jenkins-demo') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Tye Porter')
            node / gitConfigEmail('me@tyeporter.dev')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
