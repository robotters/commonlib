package github.robotters.commonlib.math.angle

/*
 * Angle Class, Used For Simple Angle Math
 */
class Angle(unit: AngleUnit, value: Double) {
  private var unit: AngleUnit = unit
  private var value: Double = value

  /*
   * Check Equality With Another Angle
   */
  fun equals(other: Angle): Boolean {
    return this.asRadians() == other.asRadians()
  }

  /* Return Underlying Value As Radians, Without Modifying Internal State */
  fun asRadians(): Double {
    if (this.unit == AngleUnit.RADIANS) {
      return this.value
    }

    return degreestoRadians(this.value)
  }

  /* Return Underlying Value As Degrees, Without Modifying Internal State */
  fun asDegrees(): Double {
    if (this.unit == AngleUnit.DEGREES) {
      return this.value
    }

    return radiansToDegrees(this.value)
  }

  /* Set Underlying Angle As Degrees */
  fun setDegrees(degrees: Double) {
    this.value = degrees
    this.unit = AngleUnit.DEGREES
  }

  /* Set Underlying Angle as Radians */
  fun setRadians(radians: Double) {
    this.value = radians
    this.unit = AngleUnit.RADIANS
  }
}
