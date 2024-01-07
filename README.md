# Entity creation
This utility allows you to create entities with only a few lines of code after configuring them in json files component by component.  
(I personally use jsons, but system supports other ways of storing entity data, just extend EntityTemplaeFactoryBy and write a parser for it)
## EntityTemplateFactory
- creates entity template by name.
## EntityTemplaeFactoryBy\<T\>
- Generic class that implements _EntityTemplateFactory_ and initializes an entity using T data
- Requires a full path to component directory, thus all the components that can be created in entity template should be stored in a single folder
## EntityTemplateFactoryByJson
- Parser from json to entity.
- Asks for a jsonValue from the JsonLoader with the name provided in _createTemplaeBy_ method.
- Reads trough each field in jsonValue, creates components and sets their field via ComponentInitializer.
- Uses singleton _Mappers_ class to quickly access entity's components.
## ComponentInitializer
- Initializes field of a component using reflection with _FieldInitializer_ of corresponding class type. (_Float_, _TextureRegion_, _Vector2_).
## FieldInitializer
- Using given config value can set the field of a component.
- Most common fieldInitializers are already added to the _ComponentInitializer_.
- Specific initializers are needed to be added manually after defining _ComponentInitializer_.  (For example TextureRegiongs got from assetManager)  