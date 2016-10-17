package r3qu13m.mc;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.LogManager;

import cpw.mods.fml.common.FMLCommonHandler;

public class SidedLogger {

	private static PrintStream stdout, stderr;
	private static boolean isDebug = false;

	private static void printf(String format, Object... args) {
		if (isDebug) {
			StackTraceElement debug = new Exception().getStackTrace()[2];
			stderr.printf("[%s] %s:%d => ", FMLCommonHandler.instance().getEffectiveSide().name(),
					debug.getFileName(), debug.getLineNumber());
			stderr.printf(format, args);
			stderr.println();
		} else {
			System.err.printf(format, args);
			System.err.println();
		}
	}

	public static void debug(String format, Object... args) {
		if (isDebug) {
			printf("[DEBUG] " + format, args);
		}
	}
	
	public static void log(String format, Object... args) {
		printf(format, args);
	}
	
	public static void setDebug() {
		isDebug = true;
	}
	
	static {
		FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
		FileOutputStream fdErr = new FileOutputStream(FileDescriptor.err);
		stdout = new PrintStream(new BufferedOutputStream(fdOut, 128), true);
		stderr = new PrintStream(new BufferedOutputStream(fdErr, 128), true);
	}
}
