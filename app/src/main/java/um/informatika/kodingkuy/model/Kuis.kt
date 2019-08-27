package um.informatika.kodingkuy.model

data class Kuis (
        val id: Int,
        var textSoal: String,
        var jawabanA: String,
        var jawabanB: String,
        var jawabanC: String,
        var jawabanD: String,
        var jawaban: String?,
        var jawabanKunci: String
)