/*
 * Author: Caitlin Hagler
 * Class: NormalSell
 * Purpose: Strategy that increases sale likelihood by 20%
 *          and exit chance by 10%.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Strategy
 */

public class NormalSell implements SalesBehavior {
    @Override
    public double getSaleModifier() {
        return 1.20;
    }
    @Override
    public double getExitModifier() {
        return 0.10;
    }
}