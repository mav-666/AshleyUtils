
# Entity creation
This util allows you to create entities with only a few lines of code after cofiguring them in json files component by component.
(I personally use jsons, but system supports other ways of storing entity data, just extend _EntityBuilder_ and write a parser for it)
## EnityBuilder
- Reads trough each compnonent and uses ComponentInitializer to init them in given entity config.
- Basic element in the system that is similiar to a builder pattern. Intended to be extended like _JsonEntityBuilder_ and use by another class such as _SummoningDirector_.
- Builder'ish pattern is used for creating complicated entities that need further configuration.
- All the component should be stored in a single folder and the path is passed in a constructor.
(For an instance an accumulation of connected entitis or initialization of a component parameters on the fly(position)).
- Uses singleton _Mappers_ class to quickly access building entity components. 
## ComponentInitializer
- Inits field of a component using reflection with _FieldInitializer_ of correspond class type (_Float_, _TextureRegion_, _Vector2_).
## FieldInitializer
- Using given config value can set the field of a component.
- Most common fieldInitializers are already added to the _ComponentInitializer_.
- Specific initializers are needed to be added manually in _ComponentInitializer_.
(For example TextureRegiongs got from assetManage)
## SummoningDirector 
- Using another entity to create a new one. 
- you can use for this perpose a specific components or a variation of SummonsComponent.
- For more clear understanding see implementation of this in my game.
(There I use ProjectileTempateComponent in barrel enitity to create bullets with different contact damage, size .etc)
