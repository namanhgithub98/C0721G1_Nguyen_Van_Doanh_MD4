package service;

public class CurrencyServiceImpl implements CurrencyService{
    @Override
    public float convert(float usd, float rate) {
        return usd*rate;
    }
}
