import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.jvm.javaField

// Hands-on 3: Custom Annotation + Reflection Validator

// Anotasi kustom @Required dengan retensi RUNTIME agar terbaca oleh reflection saat runtime
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class Required

data class RegistrasiForm(
    @Required val nama: String,
    @Required val email: String,
    val alamat: String?
)

fun validate(obj: Any): List<String> {
    val gagal = mutableListOf<String>()

    // Iterasi semua properti dari objek menggunakan reflection
    for (property in obj::class.memberProperties) {
        // Mengecek apakah properti memiliki anotasi @Required (baik di level property maupun backing field)
        val isRequired = property.findAnnotation<Required>() != null ||
                property.javaField?.getAnnotation(Required::class.java) != null

        if (isRequired) {
            val value = property.getter.call(obj)
            // Validasi: field tidak boleh bernilai null atau string kosong/blank
            if (value == null || (value is String && value.isBlank())) {
                gagal.add(property.name)
            }
        }
    }

    return gagal
}

fun main() {
    val formValid = RegistrasiForm("Siti", "siti@mail.com", null)
    println("Form valid -> gagal: ${validate(formValid)}")

    val formInvalid = RegistrasiForm("", "budi@mail.com", "Jl. Merdeka")
    println("Form invalid -> gagal: ${validate(formInvalid)}")
}
