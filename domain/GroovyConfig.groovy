import org.codehaus.groovy.ast.ClassNode
import static org.codehaus.groovy.control.customizers.builder.CompilerCustomizationBuilder.withConfig

withConfig(configuration) {
	source(classValidator: { ClassNode cn -> cn.packageName.startsWith("com.savantdegrees") }) {
		ast(groovy.transform.CompileStatic)
	}
}
