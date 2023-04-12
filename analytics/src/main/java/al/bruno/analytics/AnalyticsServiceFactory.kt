package al.bruno.analytics

interface AnalyticsServiceFactory {
    fun createAnalyticsService(analyticsType: AnalyticsType): AnalyticsService
}