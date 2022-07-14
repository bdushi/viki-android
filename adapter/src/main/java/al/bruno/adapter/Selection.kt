package al.bruno.adapter

interface Selection {
    fun selection(selection: Boolean)
    fun selection() : Boolean
    fun searchCriteria() : String
}