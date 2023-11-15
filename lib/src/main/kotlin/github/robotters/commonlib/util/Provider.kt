package github.robotters.commonlib.util

import github.robotters.commonlib.math.angle.Angle

/* Provider: Function That "Provides" a Required Underlying Type*/
typealias Provider<A> = () -> A

/* AngleProvider: Specific Function To Provide Angle */
typealias AngleProvider = Provider<Angle>
