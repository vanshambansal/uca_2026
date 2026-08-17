// Address Translation
// Objective:
// In hardware, the Memory Management Unit (MMU) uses fast bitwise operations rather than arithmetic division to split virtual addresses into a Page Number and an Offset.

// Given a 32-bit system with a standard 4096-byte (4 KB) page size:

// 4096 = 2^12, which means the lower 12 bits (bits 0–11) represent the Offset.
// The remaining upper 20 bits (bits 12–31) represent the Page Number.
// Task
// Complete the function address_translation using C bitwise operators:

// Extract the Page Number using the right-shift operator (>>).
// Extract the Offset using the bitwise AND operator (&) and the hex mask 0xFFF (binary: 0000 1111 1111 1111).

#include <stdio.h>
#include <stdint.h>

void address_translation(uint32_t virtual_address) {
    uint32_t page_number = 0;
    uint32_t offset = 0;

    // we needed to write just this and starter code was given.
    page_number = virtual_address >> 12;
    offset = virtual_address & 0xFFF;


    printf("[1A] Addr: 0x%08X -> Page: %u (0x%X), Offset: %u (0x%X)\n",
           virtual_address, page_number, page_number, offset, offset);
}

int main() {

    address_translation(0x00003A2C);

    return 0;
}