package com.sofiaverdugo.event_app.models

import android.os.Build
import androidx.annotation.RequiresApi
import com.sofiaverdugo.event_app.R
import java.time.LocalDateTime


class EventRepo {
    private val events = listOf(
        Event(1, "Encuentro comunidad FER",
            "Los invitamos al primer Encuentro Comunidad FER Talento Sonorense ⭐\uFE0F\n" +
                "Este es un evento exclusivo para becarios de nivel preparatoria y universidad. Acompáñanos y confirma tu asistencia para ser parte de este encuentro. \uD83D\uDE4C ",
            "COBACH Villa de Seris, Hermosillo",
            LocalDateTime.of(2026, 10, 15, 16, 30),
            "Gratis", "https://luma.com/qe7janb2",
            0,
            false,
            0,
            false,
            R.drawable.event1
        ),

        Event(
            2,
            "Taller de Liderazgo FER",
            "¡Descubre el líder que llevas dentro! 🌟🙌\n" +
                    "Invitamos a nuestros becarios a participar en un taller para desarrollar habilidades de liderazgo, comunicación y trabajo en equipo. ¡Aprendamos juntos y hagamos la diferencia!",
            "Hermosillo, Sonora",
            LocalDateTime.of(2026, 10, 24, 10, 0),
            "Gratis",
            "example.com",
            0,
            false,
            0,
            false,
            R.drawable.event
        ),

        Event(
            3,
            "Conferencia: Mi Futuro Profesional",
            "¡Empieza a construir el futuro que imaginas! 🎓✨\n" +
                    "Un encuentro para becarios de preparatoria y universidad donde exploraremos cómo definir metas profesionales, identificar oportunidades y prepararnos para los retos del mundo laboral.",
            "Hermosillo, Sonora",
            LocalDateTime.of(2026, 10, 29, 17, 0),
            "Gratis",
            "example.com",
            0,
            false,
            0,
            false,
            R.drawable.event
        ),

        Event(
            4,
            "Networking de Becarios FER",
            "¡Conecta, comparte e inspírate! 🤝💙\n" +
                    "Reúnete con otros becarios de la Fundación Esposos Rodríguez para compartir experiencias académicas, conocer nuevas perspectivas y crear conexiones que impulsen tu crecimiento.",
            "Hermosillo, Sonora",
            LocalDateTime.of(2026, 11, 6, 16, 30),
            "Gratis",
            "example.com",
            0,
            false,
            0,
            false,
            R.drawable.event
        ),
        Event(
            5,
            "Taller de Finanzas Personales",
            "¡Aprende a administrar tu dinero desde hoy! 💰📚\n" +
                    "Un espacio para que nuestros becarios aprendan sobre presupuestos, ahorro, metas financieras y decisiones económicas responsables durante su etapa estudiantil.",
            "Hermosillo, Sonora",
            LocalDateTime.of(2026, 11, 12, 16, 0),
            "Gratis",
            "example.com",
            0,
            false,
            0,
            false,
            R.drawable.event
        ),

        Event(
            6,
            "Encuentro de Inspiración y Superación",
            "¡Las grandes metas comienzan con pequeños pasos! 🚀⭐\n" +
                    "Acompáñanos en una jornada de historias, aprendizajes y experiencias para motivar a los becarios a perseverar en sus estudios y continuar persiguiendo sus sueños.",
            "Hermosillo, Sonora",
            LocalDateTime.of(2026, 11, 21, 11, 0),
            "Gratis",
            "example.com",
            0,
            false,
            0,
            false,
            R.drawable.event
        ),

        Event(
            7,
            "Comunidad FER: Cierre de Año",
            "¡Cerremos el año celebrando nuestros logros! 🎉💙\n" +
                    "Invitamos a los becarios de preparatoria y universidad a compartir una tarde de convivencia, dinámicas y reflexión sobre las metas alcanzadas y los retos que vienen.",
            "Hermosillo, Sonora",
            LocalDateTime.of(2026, 12, 12, 16, 30),
            "Gratis",
            "example.com",
            0,
            false,
            0,
            false,
            R.drawable.event
        ),

    )

    fun getEvents(): List<Event> {
        return events
    }
}