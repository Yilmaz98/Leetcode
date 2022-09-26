class RLEIterator {
    int[] encoded;
    int index;
    
    public RLEIterator(int[] encoding) {
        // have a copy of encoded arrays which we scan soon
        encoded = encoding;
        index = 0;
    }
    
    public int next(int n) {
        // if more number to scan than current index
        // minus out current "times"
        // and move index 2-step as only even position used for "times"
        while (index < encoded.length && n > encoded[index]) {
            n -= encoded[index];
            index += 2;
        }
        // check if out of range, so invalid --> -1
        if (index >= encoded.length) {
            return -1;
        }
        // if <= current index pointed "times"
        // do minus, then return next number (which index represented)
        encoded[index] -= n;
        return encoded[index + 1];
    }
}