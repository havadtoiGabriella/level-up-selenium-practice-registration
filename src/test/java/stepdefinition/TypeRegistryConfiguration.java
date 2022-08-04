package stepdefinition;

import java.util.Locale;
import com.selenium.nosalty.data.User;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        addPageTypeConverter(typeRegistry);
    }

    private void addPageTypeConverter(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "USER",
                ".*",
                User.class,
                (Transformer<User>) User::valueOf));
    }
}
