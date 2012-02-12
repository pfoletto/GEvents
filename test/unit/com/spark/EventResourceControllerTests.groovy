package com.spark



import org.junit.*
import grails.test.mixin.*

@TestFor(EventResourceController)
@Mock(EventResource)
class EventResourceControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/eventResource/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.eventResourceInstanceList.size() == 0
        assert model.eventResourceInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.eventResourceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.eventResourceInstance != null
        assert view == '/eventResource/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/eventResource/show/1'
        assert controller.flash.message != null
        assert EventResource.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/eventResource/list'


        populateValidParams(params)
        def eventResource = new EventResource(params)

        assert eventResource.save() != null

        params.id = eventResource.id

        def model = controller.show()

        assert model.eventResourceInstance == eventResource
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/eventResource/list'


        populateValidParams(params)
        def eventResource = new EventResource(params)

        assert eventResource.save() != null

        params.id = eventResource.id

        def model = controller.edit()

        assert model.eventResourceInstance == eventResource
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/eventResource/list'

        response.reset()


        populateValidParams(params)
        def eventResource = new EventResource(params)

        assert eventResource.save() != null

        // test invalid parameters in update
        params.id = eventResource.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/eventResource/edit"
        assert model.eventResourceInstance != null

        eventResource.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/eventResource/show/$eventResource.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        eventResource.clearErrors()

        populateValidParams(params)
        params.id = eventResource.id
        params.version = -1
        controller.update()

        assert view == "/eventResource/edit"
        assert model.eventResourceInstance != null
        assert model.eventResourceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/eventResource/list'

        response.reset()

        populateValidParams(params)
        def eventResource = new EventResource(params)

        assert eventResource.save() != null
        assert EventResource.count() == 1

        params.id = eventResource.id

        controller.delete()

        assert EventResource.count() == 0
        assert EventResource.get(eventResource.id) == null
        assert response.redirectedUrl == '/eventResource/list'
    }
}
