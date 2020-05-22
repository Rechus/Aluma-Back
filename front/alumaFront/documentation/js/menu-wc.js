'use strict';


customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">aluma-front documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                                <li class="link">
                                    <a href="dependencies.html" data-type="chapter-link">
                                        <span class="icon ion-ios-list"></span>Dependencies
                                    </a>
                                </li>
                    </ul>
                </li>
                    <li class="chapter modules">
                        <a data-type="chapter-link" href="modules.html">
                            <div class="menu-toggler linked" data-toggle="collapse" ${ isNormalMode ?
                                'data-target="#modules-links"' : 'data-target="#xs-modules-links"' }>
                                <span class="icon ion-ios-archive"></span>
                                <span class="link-name">Modules</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                        </a>
                        <ul class="links collapse " ${ isNormalMode ? 'id="modules-links"' : 'id="xs-modules-links"' }>
                            <li class="link">
                                <a href="modules/ActividadesModule.html" data-type="entity-link">ActividadesModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ActividadesModule-4671484a312407f5b421bd60c9c25e67"' : 'data-target="#xs-components-links-module-ActividadesModule-4671484a312407f5b421bd60c9c25e67"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ActividadesModule-4671484a312407f5b421bd60c9c25e67"' :
                                            'id="xs-components-links-module-ActividadesModule-4671484a312407f5b421bd60c9c25e67"' }>
                                            <li class="link">
                                                <a href="components/ActividadDetalleComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ActividadDetalleComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ActividadFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ActividadFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ActividadHomeComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ActividadHomeComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ActividadParticipantesComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ActividadParticipantesComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ActividadReservasComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ActividadReservasComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ActividadesListaComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ActividadesListaComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/AppModule.html" data-type="entity-link">AppModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-AppModule-46bdcb785b60341a857884ade0a72d90"' : 'data-target="#xs-components-links-module-AppModule-46bdcb785b60341a857884ade0a72d90"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-46bdcb785b60341a857884ade0a72d90"' :
                                            'id="xs-components-links-module-AppModule-46bdcb785b60341a857884ade0a72d90"' }>
                                            <li class="link">
                                                <a href="components/AppComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">AppComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ComunModule.html" data-type="entity-link">ComunModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ComunModule-dafe414fe4b69d713e6da1cb007a3e1e"' : 'data-target="#xs-components-links-module-ComunModule-dafe414fe4b69d713e6da1cb007a3e1e"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ComunModule-dafe414fe4b69d713e6da1cb007a3e1e"' :
                                            'id="xs-components-links-module-ComunModule-dafe414fe4b69d713e6da1cb007a3e1e"' }>
                                            <li class="link">
                                                <a href="components/CabeceraComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CabeceraComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/HomeComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">HomeComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LateralComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LateralComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PieComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PieComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ServiciosModule.html" data-type="entity-link">ServiciosModule</a>
                            </li>
                </ul>
                </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#classes-links"' :
                            'data-target="#xs-classes-links"' }>
                            <span class="icon ion-ios-paper"></span>
                            <span>Classes</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="classes-links"' : 'id="xs-classes-links"' }>
                            <li class="link">
                                <a href="classes/ActividadesService.html" data-type="entity-link">ActividadesService</a>
                            </li>
                            <li class="link">
                                <a href="classes/AppPage.html" data-type="entity-link">AppPage</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#injectables-links"' :
                                'data-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse " ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/ActividadesApiService.html" data-type="entity-link">ActividadesApiService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/AppInfoService.html" data-type="entity-link">AppInfoService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#interfaces-links"' :
                            'data-target="#xs-interfaces-links"' }>
                            <span class="icon ion-md-information-circle-outline"></span>
                            <span>Interfaces</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? ' id="interfaces-links"' : 'id="xs-interfaces-links"' }>
                            <li class="link">
                                <a href="interfaces/Actividades.html" data-type="entity-link">Actividades</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Externa.html" data-type="entity-link">Externa</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Local.html" data-type="entity-link">Local</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Participantes.html" data-type="entity-link">Participantes</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#miscellaneous-links"'
                            : 'data-target="#xs-miscellaneous-links"' }>
                            <span class="icon ion-ios-cube"></span>
                            <span>Miscellaneous</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="miscellaneous-links"' : 'id="xs-miscellaneous-links"' }>
                            <li class="link">
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});