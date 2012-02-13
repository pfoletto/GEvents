import org.ho.yaml.Yaml
input = '''
- &Country-NO
  isoCode: NO
  languageIsoCode: no
  languageVariant: null 
  localName: Norge
  englishName: Norway
  continent: Continent-Europe
'''

def country = Yaml.load(input)