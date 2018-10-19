# Reproduction repo for --combined_report=lcov bug in Bazel

Can successfully run `bazel test //...` and `bazel coverage //...`

However, running `bazel coverage --combined_report=lcov //...` fails:

```
> bazel coverage --combined_report=lcov //...
INFO: Using default value for --instrumentation_filter: "//src/main/java/com/chris[/:]".
INFO: Override the above default with --instrumentation_filter
Internal error thrown during build. Printing stack trace: java.lang.NullPointerException
	at com.google.devtools.build.lib.bazel.coverage.BazelCoverageReportModule$1.getArgs(BazelCoverageReportModule.java:108)
	at com.google.devtools.build.lib.bazel.coverage.CoverageReportActionBuilder.generateCoverageReportAction(CoverageReportActionBuilder.java:244)
	at com.google.devtools.build.lib.bazel.coverage.CoverageReportActionBuilder.createCoverageActionsWrapper(CoverageReportActionBuilder.java:192)
	at com.google.devtools.build.lib.bazel.coverage.BazelCoverageReportModule$1.createCoverageReportActionsWrapper(BazelCoverageReportModule.java:93)
	at com.google.devtools.build.lib.analysis.BuildView.createResult(BuildView.java:436)
	at com.google.devtools.build.lib.analysis.BuildView.update(BuildView.java:381)
	at com.google.devtools.build.lib.buildtool.AnalysisPhaseRunner.runAnalysisPhase(AnalysisPhaseRunner.java:212)
	at com.google.devtools.build.lib.buildtool.AnalysisPhaseRunner.execute(AnalysisPhaseRunner.java:121)
	at com.google.devtools.build.lib.buildtool.BuildTool.buildTargets(BuildTool.java:143)
	at com.google.devtools.build.lib.buildtool.BuildTool.processRequest(BuildTool.java:253)
	at com.google.devtools.build.lib.runtime.commands.TestCommand.doTest(TestCommand.java:126)
	at com.google.devtools.build.lib.runtime.commands.TestCommand.exec(TestCommand.java:106)
	at com.google.devtools.build.lib.runtime.BlazeCommandDispatcher.execExclusively(BlazeCommandDispatcher.java:484)
	at com.google.devtools.build.lib.runtime.BlazeCommandDispatcher.exec(BlazeCommandDispatcher.java:204)
	at com.google.devtools.build.lib.server.GrpcServerImpl.executeCommand(GrpcServerImpl.java:870)
	at com.google.devtools.build.lib.server.GrpcServerImpl.access$2100(GrpcServerImpl.java:111)
	at com.google.devtools.build.lib.server.GrpcServerImpl$2.lambda$run$0(GrpcServerImpl.java:939)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)

INFO: Elapsed time: 0.199s
INFO: 0 processes.
FAILED: Build did NOT complete successfully (0 packages loaded)
java.lang.NullPointerException
	at com.google.devtools.build.lib.bazel.coverage.BazelCoverageReportModule$1.getArgs(BazelCoverageReportModule.java:108)
	at com.google.devtools.build.lib.bazel.coverage.CoverageReportActionBuilder.generateCoverageReportAction(CoverageReportActionBuilder.java:244)
	at com.google.devtools.build.lib.bazel.coverage.CoverageReportActionBuilder.createCoverageActionsWrapper(CoverageReportActionBuilder.java:192)
	at com.google.devtools.build.lib.bazel.coverage.BazelCoverageReportModule$1.createCoverageReportActionsWrapper(BazelCoverageReportModule.java:93)
	at com.google.devtools.build.lib.analysis.BuildView.createResult(BuildView.java:436)
	at com.google.devtools.build.lib.analysis.BuildView.update(BuildView.java:381)
	at com.google.devtools.build.lib.buildtool.AnalysisPhaseRunner.runAnalysisPhase(AnalysisPhaseRunner.java:212)
	at com.google.devtools.build.lib.buildtool.AnalysisPhaseRunner.execute(AnalysisPhaseRunner.java:121)
	at com.google.devtools.build.lib.buildtool.BuildTool.buildTargets(BuildTool.java:143)
	at com.google.devtools.build.lib.buildtool.BuildTool.processRequest(BuildTool.java:253)
	at com.google.devtools.build.lib.runtime.commands.TestCommand.doTest(TestCommand.java:126)
	at com.google.devtools.build.lib.runtime.commands.TestCommand.exec(TestCommand.java:106)
	at com.google.devtools.build.lib.runtime.BlazeCommandDispatcher.execExclusively(BlazeCommandDispatcher.java:484)
	at com.google.devtools.build.lib.runtime.BlazeCommandDispatcher.exec(BlazeCommandDispatcher.java:204)
	at com.google.devtools.build.lib.server.GrpcServerImpl.executeCommand(GrpcServerImpl.java:870)
	at com.google.devtools.build.lib.server.GrpcServerImpl.access$2100(GrpcServerImpl.java:111)
	at com.google.devtools.build.lib.server.GrpcServerImpl$2.lambda$run$0(GrpcServerImpl.java:939)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
java.lang.NullPointerException
	at com.google.devtools.build.lib.bazel.coverage.BazelCoverageReportModule$1.getArgs(BazelCoverageReportModule.java:108)
	at com.google.devtools.build.lib.bazel.coverage.CoverageReportActionBuilder.generateCoverageReportAction(CoverageReportActionBuilder.java:244)
	at com.google.devtools.build.lib.bazel.coverage.CoverageReportActionBuilder.createCoverageActionsWrapper(CoverageReportActionBuilder.java:192)
	at com.google.devtools.build.lib.bazel.coverage.BazelCoverageReportModule$1.createCoverageReportActionsWrapper(BazelCoverageReportModule.java:93)
	at com.google.devtools.build.lib.analysis.BuildView.createResult(BuildView.java:436)
	at com.google.devtools.build.lib.analysis.BuildView.update(BuildView.java:381)
	at com.google.devtools.build.lib.buildtool.AnalysisPhaseRunner.runAnalysisPhase(AnalysisPhaseRunner.java:212)
	at com.google.devtools.build.lib.buildtool.AnalysisPhaseRunner.execute(AnalysisPhaseRunner.java:121)
	at com.google.devtools.build.lib.buildtool.BuildTool.buildTargets(BuildTool.java:143)
	at com.google.devtools.build.lib.buildtool.BuildTool.processRequest(BuildTool.java:253)
	at com.google.devtools.build.lib.runtime.commands.TestCommand.doTest(TestCommand.java:126)
	at com.google.devtools.build.lib.runtime.commands.TestCommand.exec(TestCommand.java:106)
	at com.google.devtools.build.lib.runtime.BlazeCommandDispatcher.execExclusively(BlazeCommandDispatcher.java:484)
	at com.google.devtools.build.lib.runtime.BlazeCommandDispatcher.exec(BlazeCommandDispatcher.java:204)
	at com.google.devtools.build.lib.server.GrpcServerImpl.executeCommand(GrpcServerImpl.java:870)
	at com.google.devtools.build.lib.server.GrpcServerImpl.access$2100(GrpcServerImpl.java:111)
	at com.google.devtools.build.lib.server.GrpcServerImpl$2.lambda$run$0(GrpcServerImpl.java:939)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
FAILED: Build did NOT complete successfully (0 packages loaded)
```
