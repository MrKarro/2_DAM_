from odoo import models, fields


class Libro(models.Model):
    _name = 'biblioteca.libro'
    _description = 'Modelo para representar los libros de una biblioteca'
    name = fields.Char('Título', required=True)
    date_release = fields.Date('Fecha de publicación')
    sumario = fields.Text(string='Resumen')
    pages = fields.Integer('Páginas')
    imagen = fields.Binary(string='Imagen')
    discontinued = fields.Boolean(string='Descatalogado')
    language = fields.Selection([('Es', 'Español'), ('In', 'Inglés'), ('De', 'Alemán'), ('Fr', 'Francés')],
                                string='Idioma', default='Es')
    autor_ids = fields.Many2many('biblioteca.autores', 'biblioteca_libro_autores_rel', string='Autores')
    editorial_ids = fields.Many2many('biblioteca.editorial', 'libro_id', string='Editorial')


class Autores(models.Model):
    _name = 'biblioteca.autores'
    _description = 'Modelo para representar los autores de cada libro'
    name = fields.Char('Nombre', required=True)


class Editorial(models.Model):
    _name = 'biblioteca.editorial'
    _description = 'Modelo para representar las editoriales de cada libro'
    name = fields.Char('Nombre', size=65, required=True)
    direccion = fields.Char('Direccion', required=True)
    codigopostal = fields.Integer('Codigo Postal')
    poblacion = fields.Char('Poblacion')
    provincia = fields.Text(string='Provincia', required=True)
    logo_editorial = fields.Binary(string='Imagen')
    autor_ids = fields.Many2many('biblioteca.autores', string='Autores')
    libro_id = fields.Many2many('biblioteca.libro', string='Libro')


class FichasLibrosReport(models.AbstractModel):
    _name = 'report.biblioteca_dcs.report_imprimir_fichas'
    _description = 'modelo abstracto para imprimir todas las fichas de cada libro'

    def _get_report_values(self, docids=None, data=None):

        docs = self.env['biblioteca.libro'].search([])
        return {
            'doc_ids': docids,
            'doc_model': self.env['biblioteca.libro'],
            'docs': docs,
            'data': data,
        }
