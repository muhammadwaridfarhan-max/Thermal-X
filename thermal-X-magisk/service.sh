#!/system/bin/sh

MODDIR=${0%/*}
SYSTEM_DIR=/system
MODULE_ID="thermal-x-magisk"

# Detect thermal throttling
if [ -f /proc/cpuinfo ]; then
    THERMAL_PATH=$(find /proc -name "thermal_zone*" 2>/dev/null | head -n1)
    if [ -n "$THERMAL_PATH" ] && [ -d "$THERMAL_PATH" ]; then
        echo "1" > "$THERMAL_PATH/temp"
        echo "Thermal throttling disabled by Thermal-X" > "$THERMAL_PATH/type"
    fi
fi

# Fast charging (contoh di banyak ROM)
if [ -d /sys/class/power_supply/battery ]; then
    echo "0" > /sys/class/power_supply/battery/force_fast_charge 2>/dev/null
    echo "1" > /sys/class/power_supply/battery/force_fast_charge 2>/dev/null || true
fi

# Untuk MIUI/HyperOS
if [ -f /sys/module/qti_power_on/parameters/fast_charge ]; then
    echo "1" > /sys/module/qti_power_on/parameters/fast_charge 2>/dev/null || true
fi

echo "[Thermal-X] Thermal & Fast Charging sudah di-disable" > $MODDIR/log.txt
