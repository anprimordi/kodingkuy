package um.informatika.kodingkuy.model

data class Kuis (
    val id: Int,
    val imageSoal: Int,
    val textSoal: String,
    val jawabanA: String,
    val jawabanB: String,
    val jawabanC: String,
    val jawabanD: String,
    val jawabanE: String,
    val jawaban: String?,
    val jawabanKunci: String
)