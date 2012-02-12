package com.spark



import org.junit.*
import grails.test.mixin.*

@TestFor(EventLinkController)
@Mock(EventLink)
class EventLinkControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/eventLink/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.eventLinkInstanceList.size() == 0
        assert model.eventLinkInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.eventLinkInstance != null
    }

    void testSave() {
        controller.save()

        assert model.eventLinkInstance != null
        assert view == '/eventLink/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/eventLink/show/1'
        assert controller.flash.message != null
        assert EventLink.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/eventLink/list'


        populateValidParams(params)
        def eventLink = new EventLink(params)

        assert eventLink.save() != null

        params.id = eventLink.id

        def model = controller.show()

        assert model.eventLinkInstance == eventLink
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/eventLink/list'


        populateValidParams(params)
        def eventLink = new EventLink(params)

        assert eventLink.save() != null

        params.id = eventLink.id

        def model = controller.edit()

        assert model.eventLinkInstance == eventLink
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/eventLink/list'

        response.reset()


        populateValidParams(params)
        def eventLink = new EventLink(params)

        assert eventLink.save() != null

        // test invalid parameters in update
        params.id = eventLink.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/eventLink/edit"
        assert model.eventLinkInstance != null

        eventLink.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/eventLink/show/$eventLink.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        eventLink.clearErrors()

        populateValidParams(params)
        params.id = eventLink.id
        params.version = -1
        controller.update()

        assert view == "/eventLink/edit"
        assert model.eventLinkInstance != null
        assert model.eventLinkInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/eventLink/list'

        response.reset()

        populateValidParams(params)
        def eventLink = new EventLink(params)

        assert eventLink.save() != null
        assert EventLink.count() == 1

        params.id = eventLink.id

        controller.delete()

        assert EventLink.count() == 0
        assert EventLink.get(eventLink.id) == null
        assert response.redirectedUrl == '/eventLink/list'
    }
}
