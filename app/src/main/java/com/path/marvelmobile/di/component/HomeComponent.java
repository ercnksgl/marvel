package com.path.marvelmobile.di.component;


import com.path.marvelmobile.di.MScope;
import com.path.marvelmobile.di.module.HomeModule;
import com.path.marvelmobile.ui.base.BaseActivity;
import com.path.marvelmobile.ui.characterDetails.CharacterDetailsFragment;
import com.path.marvelmobile.ui.home.HomeFragment;

import dagger.Component;


@MScope
@Component( dependencies = AppComponent.class,modules = {HomeModule.class})
public interface HomeComponent {

    void inject(BaseActivity baseActivity);

    void inject(HomeFragment homeFragment);

    void inject(CharacterDetailsFragment characterDetailsFragment);

}
