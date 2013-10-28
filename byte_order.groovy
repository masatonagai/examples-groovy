import static java.nio.ByteOrder.*
def bo = {
    try {
        // get the host byte order but not the jvm byte order
        nativeOrder() == BIG_ENDIAN ?
            'big endian' : 'little endian'
    } catch (Error e) {
        'unknown'
    }
}()
println bo
