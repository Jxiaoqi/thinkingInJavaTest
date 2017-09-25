package holding;

import java.util.Map;

/**
 * Foreach 与 迭代器
 * 		该代码显示了所有的操作系统环境变量.
 * @author admin
 *
 */
public class EnvironmentVariables {
	public static void main(String[] args) {
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + 
									entry.getValue());
		}
		
		/**
		 * USERPROFILE: C:\Users\admin
ProgramData: C:\ProgramData
PATHEXT: .COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC
windows_tracing_logfile: C:\BVTBin\Tests\installpackage\csilogfile.log
JAVA_HOME: D:\jws\jws\bin\jdk1.7.0_55
ProgramFiles(x86): C:\Program Files (x86)
windows_tracing_flags: 3
TEMP: C:\Users\admin\AppData\Local\Temp
SystemDrive: C:
ProgramFiles: C:\Program Files
Path: C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\TortoiseSVN\bin;D:\jws\jws\tools\apache-maven-3.2.1\bin;C:\Program Files\Git\cmd;D:\jws\jws\bin\jdk1.7.0_55/bin;D:\jws\jws\bin\jdk1.7.0_55/jre/bin
HOMEDRIVE: C:
PROCESSOR_REVISION: 3a09
USERDOMAIN: admin-PC
ALLUSERSPROFILE: C:\ProgramData
ProgramW6432: C:\Program Files
PROCESSOR_IDENTIFIER: Intel64 Family 6 Model 58 Stepping 9, GenuineIntel
SESSIONNAME: Console
TMP: C:\Users\admin\AppData\Local\Temp
CommonProgramFiles: C:\Program Files\Common Files
CLASSPATH: .;D:\jws\jws\bin\jdk1.7.0_55/lib/dt.jar;D:\jws\jws\bin\jdk1.7.0_55/lib/tools.jar
=::: ::\
LOGONSERVER: \\ADMIN-PC
PROCESSOR_ARCHITECTURE: AMD64
FP_NO_HOST_CHECK: NO
OS: Windows_NT
HOMEPATH: \Users\admin
PROCESSOR_LEVEL: 6
CommonProgramW6432: C:\Program Files\Common Files
LOCALAPPDATA: C:\Users\admin\AppData\Local
COMPUTERNAME: ADMIN-PC
windir: C:\Windows
SystemRoot: C:\Windows
NUMBER_OF_PROCESSORS: 4
USERNAME: admin
PUBLIC: C:\Users\Public
PSModulePath: C:\Windows\system32\WindowsPowerShell\v1.0\Modules\
CommonProgramFiles(x86): C:\Program Files (x86)\Common Files
ComSpec: C:\Windows\system32\cmd.exe
APPDATA: C:\Users\admin\AppData\Roaming
		 */
	}
}
