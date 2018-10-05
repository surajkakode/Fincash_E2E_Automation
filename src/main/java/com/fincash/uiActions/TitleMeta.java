package com.fincash.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TitleMeta {

    public static final Logger log = Logger.getLogger(TitleMeta.class.getClass());

    @FindBy(xpath = "//meta[@name='description']")
    WebElement meta;

    public String getMeta()
    {
        String actualMeta= meta.getText();
        return actualMeta;
    }

    public boolean compare(String expected, String actual)
    {
        if (actual.equals(expected))
            return true;
        else return false;
    }

    final String home= "Fincash: Invest in Best Performing Mutual Funds in India";

   /* String explore_all: `Explore & Invest in Top Mutual Funds Online - Fincash.com`,
    String explore_sip: `Explore Best SIP Mutual Funds | Choose Best SIP Plans`,
    String sip: `Systematic Investment Plan | SIP Calculator | Best SIP Plan`,
    String smart_sip: `Invest in Best SIP Funds via SmartSIP | Make SIP Investment Today`,
    String smart_sip_large_cap: `SmartSIP | Invest in Best Large Cap Funds & Grow Long-Term Wealth`,
    String smart_sip_balanced: `SmartSIP | Invest in Best Balanced Funds & Balance your Portfolio`,
    String smart_sip_diversified: `SmartSIP | Invest in Best Diversified Funds & Earn Safe Returns`,
    String smart_sip_mid_small_cap: `SmartSIP | Invest in Best Mid & Small Cap Funds`,
    smart_sip_sector: `SmartSIP | Invest in Best Sector Funds & Earn Long-term Returns`,
    smart_sip_global: `SmartSIP | Invest in Best Global Funds & Diversify Investments`,
    sip_calculator: `SIP Calculator | Analyse Financial Goals & Calculate SIP Growth`,
    sip_calculator_goal: `SIP Calculator | Calculate SIP Investment for Financial goal`,
    sip_calculator_return: `SIP Calculator | Calculate SIP returns`,
    lumpsum_calculator_goal: `Lumpsum Calculator | Calculate Lumpsum Investment,
    lumpsum_calculator_return: `Lumpsum Calculator | Mutual Fund Return Calculator`,
    tax_calculator: `Income Tax Calculator | Save Tax Under Section 80C via ELSS Funds`,
    tax: `Tax Saving Mutual Funds | ELSS Funds | Tax Calculator`,
    explore_tax: `Explore Best ELSS Funds | Make Tax Saving Investments Under Sec 80C`,
    tax_saver: `Invest in Best ELSS Fund via TaxSaver | Make Tax Saving Investment`,
    tax_saver_funds_top3: `TaxSaver | Invest in Best ELSS Funds to Save Tax & Earn Returns`,
    tax_saver_funds_top5: `TaxSaver | Invest in Best ELSS & Save tax under Sec 80C`,
    cash: `SavingsPlus: Earn Better Returns Than Your Bank Savings Account`,
    cash_demo: `SavingsPlus: Earn Better Returns Than Your Bank Savings Account`,
    cash_funds: `Invest in SavingsPlus | Save & Earn Better Than Your Bank Savings Account`,
    cash_funds_deposit_plan: `SavingsPlus | Invest in Best Ultra Short Term Funds & Beat FD Returns`,
    cash_funds_arbitrage_plan: `SavingsPlus | Invest in Best Arbitrage Funds & Earn Optimal Returns `,
    cash_funds_short_term_plan: `Invest in Best Short Term Plans & Earn Good Returns`,
    cash_funds_short_term_gilt_plan: `Invest in Best Short Term Gilt Plans & Grow Money in Short Duration`,
    cash_funds_dynamic_bond_gilt_plan: `Invest in Best Dynamic Bond Gilt Plans & Earn Superior Returns`,
    cash_funds_corporate_bond_plan: `Invest in Best Corporate Bond Plans & Earn Optimal Returns `,
    cash_funds_dynamic_bond_plan: `Invest in Best Dynamic Bond Plans & Earn Good Profits`,
    cash_funds_monthly_income_plan: `Invest in Best Monthly Income Plans | Earn Profits of both Debt & Equity`,
    cash_funds_gold_investment_plan: `Invest in Best Gold Plans | Secure your money against inflation`,
    cash_funds_long_term_gilt_plan: `Invest in Best Long Term Gilt Plans & Earn Good Returns`,

    */
}
