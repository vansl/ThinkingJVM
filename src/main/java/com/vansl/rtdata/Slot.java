package com.vansl.rtdata;

import com.vansl.rtdata.heap.Object;
import lombok.Data;

@Data
public class Slot {

    private int num;
    private Object ref;
}
