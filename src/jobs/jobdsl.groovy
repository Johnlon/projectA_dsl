// see also .. https://github.com/gimp-ci/jenkins-dsl/blob/2c53863eca8d689f23bd8554a3cd47831bfa7606/jobs/gimp_multibranch_pipelines.groovy#L27-L29
// re branch discovery

import utils.JobConfigurator

def cfg = new JobConfigurator(this, out, [
        gitRepo: "infra/projectA_ci",
        branches: "master|develop"
])

cfg.multibranchPipeline jobName: "/projectA/ci_job1", scriptPath: "Jenkinsfile.job1"
cfg.multibranchPipeline jobName: "/projectA/ci_job2", scriptPath: "Jenkinsfile.job2"

buildMonitorView("/projectA/ci_jobs") {
    description("my ci jobs")
    jobs {
        regex("/projectA/ci_.*")
    }
}
