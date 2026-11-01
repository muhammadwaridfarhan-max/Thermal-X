#!/system/bin/sh
MODDIR=${0%/*}

THERMAL_PATH=$(find /proc -name "thermal_zone*" 2>/dev/null | head -n1)
if [ -n "$THERMAL_PATH" ] && [ -d "$THERMAL_PATH" ]; then
    echo "1" > "$THERMAL_PATH/temp" 2>/dev/null || true
    echo "Thermal-X Disabled" > "$THERMAL_PATH/type" 2>/dev/null || true
fi

if [ -d /sys/class/power_supply/battery ]; then
    echo "0" > /sys/class/power_supply/battery/force_fast_charge 2>/dev/null || true
    echo "1" > /sys/class/power_supply/battery/force_fast_charge 2>/dev/null || true
fi

if [ -f /sys/module/qti_power_on/parameters/fast_charge ]; then
    echo "1" > /sys/module/qti_power_on/parameters/fast_charge 2>/dev/null || true
fi

echo "[Thermal-X KernelSU] Thermal & Fast Charging sudah di-disable" > $MODDIR/log.txt
