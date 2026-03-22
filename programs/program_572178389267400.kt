class class_0 {
    fun fun_0(): Unit {
                try {
            var var_0: Int = 100
            val var_1: () -> Int = {                 try {
                } catch (e: IllegalArgumentException) {
                }
                val var_8: Boolean? = null
                val var_11: class_0? = null
                val var_15: String? = null
(0-var_0)
            }
        } catch (e: RuntimeException) {
        }
                val var_9: () -> String = {             try {
            } catch (e: RuntimeException) {
            }
            val var_12: String? = null
""
        }
                val var_13: () -> Boolean = {             try {
            } catch (e: RuntimeException) {
            }
false
        }
    }
    operator fun <T_1 : Comparable<T_1>, T_4 : java.io.Serializable> minus(other: class_0): Int {
                val var_3: () -> Int = {             try {
            } catch (e: IllegalArgumentException) {
            }
            val var_7: Boolean? = null
            val var_16: T_1? = null
(0*37)
        }
                val var_10: () -> Int = {             try {
            } catch (e: Throwable) {
            }
(0-51)
        }
                return 0
    }
    val var_2: Any
        field = suspend { }
    val var_4: Throwable
        field = RuntimeException()
    val var_5: Boolean
        get() {
            kotlin.contracts.contract { returns(true) implies (this@class_0 is class_0) }
            return var_4 is RuntimeException
        }
    @OptIn(kotlin.contracts.ExperimentalContracts::class, kotlin.contracts.ExperimentalExtendedContracts::class)
    inline fun <reified T_0 : Throwable, reified T_2, reified T_3> fun_3(block_0: () -> Unit, cond_0: Boolean, noinline block_1: () -> Unit): Unit {
        kotlin.contracts.contract { cond_0.holdsIn<Unit>(block_1) }
                try {
block_0()
        } catch (e: T_0) {
            val var_6: Class<T_0> = T_0::class.java
        }
        block_1()
                val var_14: Boolean = (var_2 is T_3)
    }
    suspend fun fun_4(): Unit {

    }
}
typealias Alias_alias_0 = List<Map<String, Int>>
fun fun_2(): Unit {

}
typealias Alias_alias_1 = Map<String, List<Int>>