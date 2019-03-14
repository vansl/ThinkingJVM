package com.vansl.rtdata;

import com.vansl.rtdata.heap.HeapObject;
import lombok.Data;

@Data
public class Slot {

    private int num;
    private HeapObject ref;
}
