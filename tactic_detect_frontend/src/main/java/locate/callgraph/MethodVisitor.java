package locate.callgraph;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MethodVisitor extends EmptyVisitor {

	JavaClass visitedClass;
	private MethodGen mg;
	private ConstantPoolGen cp;

	private String DegreeClass;
	private String DegreeMethod;
	private FileWriter desfileWriter;

	public MethodVisitor(MethodGen m, JavaClass jc,  FileWriter fileWriter) {
		visitedClass = jc;
		mg = m;
		cp = mg.getConstantPool();
		desfileWriter = fileWriter;
	}

	public void start() {
		if (mg.isAbstract() || mg.isNative())
			return;
		for (InstructionHandle ih = mg.getInstructionList().getStart(); ih != null; ih = ih.getNext()) {
			Instruction i = ih.getInstruction();

			if (!visitInstruction(i))
				i.accept(this);
		}
	}

	private boolean visitInstruction(Instruction i) {
		short opcode = i.getOpcode();
		return ((InstructionConstants.INSTRUCTIONS[opcode] != null) && !(i instanceof ConstantPushInstruction)
				&& !(i instanceof ReturnInstruction));
	}

	@Override
	public void visitINVOKEVIRTUAL(INVOKEVIRTUAL i) {
		String formatInternal = "%s";
		this.DegreeClass = String.format(formatInternal, i.getReferenceType(cp));
		this.DegreeMethod = i.getMethodName(cp);
//		System.out.println(visitedClass.getClassName() + ":" + mg.getName() + " CALL " + this.DegreeClass + ":"
//				+ this.DegreeMethod);
		try {
			desfileWriter.write(visitedClass.getClassName() + ":"
					+ mg.getName()
					+ "<<"
					+ Arrays.toString(mg.getArgumentTypes())
					+ ">>"
					+"@@"
					+mg.getReturnType()
					+"@@"
					+ "==>"
					+ this.DegreeClass + ":"
					+ this.DegreeMethod + "\r\n");
			desfileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}