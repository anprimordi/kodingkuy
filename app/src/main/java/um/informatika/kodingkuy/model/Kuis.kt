package um.informatika.kodingkuy.model

data class Kuis (
        val id: Int,
        val textSoal: String,
        var jawabanA: String,
        var jawabanB: String,
        var jawabanC: String,
        var jawabanD: String,
        var jawaban: String?,
        val jawabanKunci: String
)