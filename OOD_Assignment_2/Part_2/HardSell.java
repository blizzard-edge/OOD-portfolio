/*
 * Author: Caitlin Hagler
 * Class: HardSell
 * Purpose: Strategy that increases sale likelihood by 25% 
 *          and exit chance by 25%.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Strategy
 */

public class HardSell implements SalesBehavior {
    @Override
    public double getSaleModifier() {
        return 1.25;
    }
    @Override
    public double getExitModifier() {
        return 0.25;
    }
}