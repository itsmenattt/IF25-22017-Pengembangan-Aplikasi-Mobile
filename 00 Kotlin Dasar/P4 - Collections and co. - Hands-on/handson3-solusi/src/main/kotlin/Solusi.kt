// Hands-on 3: Sequence vs List (Lazy Evaluation)
// Solusi: Membandingkan evaluasi eager (List) dengan evaluasi lazy (Sequence)

fun prosesDenganList(data: List<Int>): List<Int> {
    // Evaluasi eager: setiap tahap membuat intermediate list baru untuk 1.000.000 elemen
    return data
        // 1. Menyaring seluruh elemen data untuk mencari angka genap
        .filter { it % 2 == 0 }
        // 2. Mengalikan kuadrat seluruh elemen hasil saringan
        .map { it * it }
        // 3. Mengambil 5 elemen pertama dari hasil akhir
        .take(5)
}

fun prosesDenganSequence(data: List<Int>): List<Int> {
    // Evaluasi lazy: elemen diproses satu per satu sepanjang pipeline hingga syarat terpenuhi
    return data
        // 1. Mengubah List menjadi Sequence untuk mengaktifkan evaluasi malas (lazy)
        .asSequence()
        // 2. Menyaring angka genap per elemen
        .filter { it % 2 == 0 }
        // 3. Mengalikan kuadrat hanya untuk elemen yang lolos saringan
        .map { it * it }
        // 4. Berhenti memproses setelah 5 elemen pertama terpenuhi
        .take(5)
        // 5. Operasi terminal: mengumpulkan hasil akhir ke dalam List
        .toList()
}

fun main() {
    // Menyiapkan dataset 1 juta bilangan bulat
    val data = (1..1_000_000).toList()

    // Mengukur waktu eksekusi pendekatan List (eager)
    val startList = System.currentTimeMillis()
    val hasilList = prosesDenganList(data)
    val waktuList = System.currentTimeMillis() - startList
    println("List    : $hasilList (${waktuList}ms)")

    // Mengukur waktu eksekusi pendekatan Sequence (lazy)
    val startSeq = System.currentTimeMillis()
    val hasilSequence = prosesDenganSequence(data)
    val waktuSequence = System.currentTimeMillis() - startSeq
    println("Sequence: $hasilSequence (${waktuSequence}ms)")
}
