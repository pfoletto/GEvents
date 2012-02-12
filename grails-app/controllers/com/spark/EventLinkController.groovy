package com.spark

import org.springframework.dao.DataIntegrityViolationException

class EventLinkController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [eventLinkInstanceList: EventLink.list(params), eventLinkInstanceTotal: EventLink.count()]
    }

    def create() {
        [eventLinkInstance: new EventLink(params)]
    }

    def save() {
        def eventLinkInstance = new EventLink(params)
        if (!eventLinkInstance.save(flush: true)) {
            render(view: "create", model: [eventLinkInstance: eventLinkInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'eventLink.label', default: 'EventLink'), eventLinkInstance.id])
        redirect(action: "show", id: eventLinkInstance.id)
    }

    def show() {
        def eventLinkInstance = EventLink.get(params.id)
        if (!eventLinkInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventLink.label', default: 'EventLink'), params.id])
            redirect(action: "list")
            return
        }

        [eventLinkInstance: eventLinkInstance]
    }

    def edit() {
        def eventLinkInstance = EventLink.get(params.id)
        if (!eventLinkInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventLink.label', default: 'EventLink'), params.id])
            redirect(action: "list")
            return
        }

        [eventLinkInstance: eventLinkInstance]
    }

    def update() {
        def eventLinkInstance = EventLink.get(params.id)
        if (!eventLinkInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventLink.label', default: 'EventLink'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (eventLinkInstance.version > version) {
                eventLinkInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'eventLink.label', default: 'EventLink')] as Object[],
                          "Another user has updated this EventLink while you were editing")
                render(view: "edit", model: [eventLinkInstance: eventLinkInstance])
                return
            }
        }

        eventLinkInstance.properties = params

        if (!eventLinkInstance.save(flush: true)) {
            render(view: "edit", model: [eventLinkInstance: eventLinkInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'eventLink.label', default: 'EventLink'), eventLinkInstance.id])
        redirect(action: "show", id: eventLinkInstance.id)
    }

    def delete() {
        def eventLinkInstance = EventLink.get(params.id)
        if (!eventLinkInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventLink.label', default: 'EventLink'), params.id])
            redirect(action: "list")
            return
        }

        try {
            eventLinkInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'eventLink.label', default: 'EventLink'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'eventLink.label', default: 'EventLink'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
