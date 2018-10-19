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

Manually providing the `--coverage_report_generator` flag works:

```
> bazel coverage --combined_report=lcov --coverage_report_generator="@bazel_tools//tools/test/LcovMerger/java/com/google/devtools/lcovmerger:Main" //...
INFO: Using default value for --instrumentation_filter: "//src/main/java/com/chris[/:]".
INFO: Override the above default with --instrumentation_filter
INFO: Analysed 5 targets (23 packages loaded).
INFO: Found 3 targets and 2 test targets...
INFO: LCOV coverage report is located at /home/chris.rice/.cache/bazel/_bazel_chris.rice/1baebf64cb080dc7a8e39a79a89b8741/execroot/__main__/bazel-out/_coverage/_coverage_report.dat
 and execpath is bazel-out/_coverage/_coverage_report.dat
INFO: From CoverageReport _coverage/_coverage_report.dat:
Oct 19, 2018 8:57:48 AM com.google.devtools.lcovmerger.Main getTracefiles
INFO: Found 2 tracefiles.
Oct 19, 2018 8:57:48 AM com.google.devtools.lcovmerger.Main parseFiles
SEVERE: Parsing file bazel-out/k8-fastbuild/testlogs/src/test/java/com/chris/foo/FooTest/coverage.dat
Oct 19, 2018 8:57:48 AM com.google.devtools.lcovmerger.Main parseFiles
SEVERE: Parsing file bazel-out/k8-fastbuild/testlogs/src/test/java/com/chris/hello/HelloWorldTest/coverage.dat
Oct 19, 2018 8:57:48 AM com.google.devtools.lcovmerger.Main getGcovInfoFiles
SEVERE: No gcov info file found.
INFO: Elapsed time: 6.037s, Critical Path: 5.47s
INFO: 15 processes: 10 linux-sandbox, 5 worker.
INFO: Build completed successfully, 35 total actions
//src/test/java/com/chris/foo:FooTest                                    PASSED in 0.7s
  /home/chris.rice/.cache/bazel/_bazel_chris.rice/1baebf64cb080dc7a8e39a79a89b8741/execroot/__main__/bazel-out/k8-fastbuild/testlogs/src/test/java/com/chris/foo/FooTest/coverage.dat
//src/test/java/com/chris/hello:HelloWorldTest                           PASSED in 0.6s
  /home/chris.rice/.cache/bazel/_bazel_chris.rice/1baebf64cb080dc7a8e39a79a89b8741/execroot/__main__/bazel-out/k8-fastbuild/testlogs/src/test/java/com/chris/hello/HelloWorldTest/coverage.dat
```
