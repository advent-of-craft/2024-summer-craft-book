package order

class Order(
    var status: Int,
    var items: Int,
    var total: Double
) {
    companion object {
        const val UNPROCESSED = 0
        const val PROCESSED = 1
    }
}