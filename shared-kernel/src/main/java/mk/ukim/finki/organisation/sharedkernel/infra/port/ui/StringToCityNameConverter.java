/*package mk.ukim.finki.organisation.sharedkernel.infra.port.ui;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import mk.ukim.finki.organisation.sharedkernel.domain.geo.CityName;

public class StringToCityNameConverter implements Converter<String, CityName> {

    @Override
    public Result<CityName> convertToModel(String value, ValueContext context) {
        return value == null ? Result.ok(null) : Result.ok(new CityName(value));
    }

    @Override
    public String convertToPresentation(CityName value, ValueContext context) {
        return value == null ? "" : value.toString();
    }
}
*/